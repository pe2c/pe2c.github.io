(ns pe2c-cljs.views.who-we-are
  (:require [re-frame.core :as re-frame]
            [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.db :as db]
            [pe2c-cljs.locales :refer [t]]))

(defn member-chip
  [{:keys [img entry position] :as member}]
  [:a.member-chip {:href (when-not (= entry @(re-frame/subscribe [:displayed-biography]))
               "#member-biography")
       :on-click (fn [& _]
                   (re-frame/dispatch [:toggle-displayed-biography entry]))}
   [:img.member-chip-face {:alt ""
          :src img
          :style (styles/member-chip-face (= entry @(re-frame/subscribe [:displayed-biography])))}]
   [:div {:style {:font-weight :bold
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
   (let [biography-entry @(re-frame/subscribe [:displayed-biography])]
     [:div {:style {:text-align :justify}}
      [:div#member-biography ;; ugly hack
       ]
      (if biography-entry
        [:p (str (t :who-we-are :biography-of) " ") (t :who-we-are biography-entry :name)]
        [:p (t :who-we-are :click-face)])
      (when biography-entry
        (doall (map (fn [a] ^{:key a} [:p a])
                    (t :who-we-are biography-entry :biography))))])])
