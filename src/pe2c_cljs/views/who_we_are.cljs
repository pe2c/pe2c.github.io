(ns pe2c-cljs.views.who-we-are
  (:require [re-frame.core :as re-frame]
            [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.db :as db]
            [pe2c-cljs.locales :refer [t]]))

(defn member-chip
  [{:keys [img entry position] :as member}]
  [:a {:href (when-not (= entry @(re-frame/subscribe [:displayed-biography]))
               "#member-biography")
       :style (assoc styles/flex-center
                :margin 60
                :text-decoration :none
                :flex-direction :column)
       :on-click (fn [& _]
                   (re-frame/dispatch [:toggle-displayed-biography entry]))}
   [:img {:alt ""
          :src img
          :style {:object-fit :contain
                  :width 200
                  :height 200
                  :border-radius "50%"
                  :border (if (= entry @(re-frame/subscribe [:displayed-biography]))
                            (str "7px solid " styles/logo-blue-strong)
                            "7px solid #fff")
                  :margin-bottom 15}}]
   [:div {:style {:font-size 24
                  :font-weight :bold
                  :color styles/dark-strong}}
    (t :who-we-are entry :name)]
   [:div {:style {:color styles/dark-strong}} (t :who-we-are position)]])

(defn section
  [id]
  [:section {:id id}
   [:header {:style styles/flex-center}
    [:h2 (t :who-we-are :heading)]]

   (->> db/members
        (partition 2)
        ;; so it's 2 row of 2 members or 4 rows of 1 each but never all members in a row.
        (map (fn [mm]
               ^{:key mm} [:div {:style styles/flex-center}
                           (doall (map #(do ^{:key %} [member-chip %]) mm))]))
        doall)

   [:div#member-biography
    ;; FIXME Ugly hack, so scrolling to biography isn't hidden by 50-px-high banner
    ;; FIXME Doesn't work as is in responsive design
    {:style {:margin-top -150
             :position :absolute
             :background-color :lime}}]
   (when-let [biography-entry @(re-frame/subscribe [:displayed-biography])]
     [:div {:style {:padding "0 250px"
                    :font-size 22
                    :text-align :justify}}
      [:p (str (t :who-we-are :biography-of) " ") (t :who-we-are biography-entry :name)]
      (doall (map (fn [a] ^{:key a} [:p a])
                  (t :who-we-are biography-entry :biography)))])])
