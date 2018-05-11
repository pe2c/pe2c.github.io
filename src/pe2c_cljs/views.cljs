(ns pe2c-cljs.views
  (:require [re-frame.core :as re-frame]
            [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.lorem-ipsum :as lorem-ipsum]
            [pe2c-cljs.locales :refer [t]]
            [goog.object :as object]
            [clojure.string :as str]))

(def sections-collapsed-height
  50)

(defn collapsible-sections-pred
  [{:scroll/keys [y]}]
  (let [threshold sections-collapsed-height]
    (if (<= y threshold)
      :sections/expanded
      :sections/collapsed)))

(defn- sections
  []
  (let [collapsible-state (re-frame/subscribe [:window/scroll-trigger collapsible-sections-pred])]
    (fn []
      (let [collapsible-style (case @collapsible-state
                                :sections/collapsed {:background-color styles/dark-strong
                                                     :position :fixed
                                                     :height sections-collapsed-height
                                                     :visibility :visible}
                                :sections/expanded {:position :fixed
                                                    :padding-top 15
                                                    :padding-bottom 15
                                                    :visibility :visible})
            menu-item-color (case @collapsible-state
                              :sections/collapsed styles/logo-blue-light
                              :sections/expanded :white)]
        [:div#collapsible-title {:style (merge {:transition-property [:background-color :padding :visibility]
                                                :transition-duration "0.4s"
                                                :transition-delay "0s"
                                                :z-index 1
                                                :width "100%"
                                                :top 0
                                                :right 0
                                                :display :flex
                                                :flex-wrap :wrap
                                                :flex-direction :row
                                                :justify-content :center
                                                :transition-timing-function "ease-in-out"}
                                               collapsible-style)}
         [:a.menu-item {:style {:color menu-item-color} :href "#offer"} (t :menu-item :offer)]
         [:a.menu-item {:style {:color menu-item-color} :href "#choose-us"} (t :menu-item :choose-us)]
         [:a.menu-item {:style {:color menu-item-color} :href "#added-value"} (t :menu-item :added-value)]
         [:a.menu-item {:style {:color menu-item-color} :href "#who-we-are"} (t :menu-item :who-we-are)]
         [:a.menu-item {:style {:color menu-item-color} :href "#get-in-touch"} (t :menu-item :get-in-touch)]]))))

(defn title
  []
  [:div {:style {:margin-top 150
                 :display :flex
                 :flex-direction :row
                 :flex-wrap :wrap
                 :align-items :center
                 :justify-content :center}}
   [:div#landing-screen {:style {:transition-property [:background-color :padding :visibility]
                                 :transition-duration "0.4s"
                                 :transition-delay "0s"
                                 :display :flex
                                 :flex-direction :row
                                 :flex-wrap :wrap
                                 :align-items :center
                                 :justify-content :center}}
    [:img {:alt "Logo of PE2C"
           :src "img/logos/pe2c.svg"
           :style {:height 360
                   :background "radial-gradient(ellipse at center, rgba(255,255,255,1) 0%,rgba(255,255,255,1) 35%,rgba(255,255,255,0.31) 60%,rgba(0,0,0,0) 71%)"}}]
    [:div {:style {:display :flex
                   :flex-direction :column
                   :justify-content :flex-end
                   :align-items :flex-end
                   :padding "30px 45px"}}
     [:h1 {:style {:font-size 28
                   :background-color :white}}
      (t :title :title)]
     [:h1 {:style {:font-size 80
                   :background-color :white}}
      (t :title :sub-title)]]]])

(defn offer-opportunities
  []
  [:div {:style {:flex 1
                 :padding 15}}
   [:img {:alt ""
          :src "img/offer/recherche.png"
          :style {:object-fit :contain
                  :width 128
                  :height 128}}]
   [:h3 (t :offer :opportunity :heading)]
   [:p (t :offer :opportunity :text)]
   [:ul (map (fn [bullet] [:li bullet])
             (t :offer :opportunity :bullets))]])

(defn offer-network
  []
  [:div {:style {:flex 1
                 :padding 15}}
   [:img {:alt ""
          :src "img/offer/teamup.png"
          :style {:object-fit :contain
                  :width 128
                  :height 128}}]
   [:h3 (t :offer :network :heading)]
   [:p (t :offer :network :text)]
   [:ul (map (fn [bullet] [:li bullet])
             (t :offer :network :bullets))]])

(defn offer-follow-up
  []
  [:div {:style {:flex 1
                 :padding 15}}
   [:img {:alt ""
          :src "img/offer/network.png"
          :style {:object-fit :contain
                  :width 128
                  :height 128}}]

   [:h3 (t :offer :follow-up :heading)]
   [:p (t :offer :follow-up :text)]
   [:ul (map (fn [bullet] [:li bullet])
             (t :offer :follow-up :bullets))]])

(defn offer
  []
  [:section#offer {:style {:display :flex
                           :flex-direction :row
                           :flex-wrap :wrap
                           :justify-content :center
                           :padding-left 200
                           :text-align :justify
                           :padding-right 200}}
   [:header {:style {:display :flex
                     :flex-direction :column
                     :flex-wrap :wrap
                     :align-items :center}}
    [:h2 (t :offer :heading)]
    [:div (t :offer :caption)]]
   [:div {:style {:display :flex
                  :flex-direction :row
                  :flex-wrap :wrap
                  :justify-content :space-between}}
    [offer-opportunities]
    [offer-network]
    [offer-follow-up]]])

(defn choose-us
  []
  [:section#choose-us
   [:header {:style {:display :flex
                     :flex-direction :column
                     :flex-wrap :wrap
                     :align-items :center}}
    [:h2 (t :choose-us :heading)]]

   [:div {:style {:display :flex
                  :flex-direction :row
                  :flex-wrap :wrap}}
    [:div {:style {:flex 1
                   :padding 15
                   :display :flex
                   :flex-direction :column
                   :flex-wrap :wrap}}
     [:div
      [:p (t :choose-us :action :catch-line)]
      [:ul (map (fn [bullet] [:li bullet])
                (t :choose-us :action :bullets))]]

     [:p [:span {:style {:font-weight :bold}} (t :choose-us :ethos :catch-line)] (t :choose-us :ethos :text)]]
    [:div {:style {:flex 1
                   :padding 15}}
     "put a picture here"]
    [:div {:style {:flex 1
                   :padding 15
                   :display :flex
                   :flex-direction :column
                   :flex-wrap :wrap}}
     [:p [:span {:style {:font-weight :bold}} (t :choose-us :team :catch-line)] (t :choose-us :team :text)]
     [:p [:span {:style {:font-weight :bold}} (t :choose-us :network :catch-line)] (t :choose-us :network :text)]]]])

(defn added-value
  []
  [:section#added-value
   [:header {:style {:display :flex
                     :flex-direction :column
                     :flex-wrap :wrap
                     :align-items :center}}
    [:h2 (t :added-value :heading)]]
   [:div {:style {:display :flex
                  :flex-direction :row
                  :flex-wrap :wrap
                  :justify-content :center
                  :align-items :center}}
    [:img {:alt ""
           :src "img/added-value/added-value.png"
           :style {:object-fit :contain
                   :width "20%"
                   :height "20%"}}]
    [:ol (map (fn [bullet] [:li bullet])
              (t :added-value :bullets))]]])

(def members
  ;; TODO better use re-frame db for this
  [{:img "img/team/geraud-de-boisset.jpg"
    :entry :geraud-de-boisset
    :position :president-associate}
   {:img "img/team/arnaud-ladrange.jpg"
    :entry :arnaud-ladrange
    :position :associate}
   {:img "img/team/pierre-niclot.jpg"
    :entry :pierre-niclot
    :position :associate}
   {:img "img/team/michel-ravet.jpg"
    :entry :michel-ravet
    :position :associate}])

(defn member-chip
  [{:keys [img entry position]}]
  [:a {:href (when-not (= entry @(re-frame/subscribe [:displayed-biography]))
               "#member-biography")
       :style {:margin 60
               :text-decoration :none
               :display :flex
               :flex-direction :column
               :flex-wrap :wrap
               :align-items :center
               :justify-content :center}
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
                            "7px solid #fff")}}]
   [:div {:style {:font-size 24
                  :font-weight :bold
                  :color styles/dark-strong}}
    (t :who-we-are entry :name)]
   [:div {:style {:color styles/dark-strong}} (t :who-we-are position)]])

(defn who-we-are
  []
  [:section#who-we-are
   [:header {:style {:display :flex
                     :flex-direction :column
                     :flex-wrap :wrap
                     :align-items :center}}
    [:h2 (t :who-we-are :heading)]]

   (->> members
        (partition 2)
        ;; so it's 2 row of 2 members or 4 rows of 1 each but never all members in a row.
        (map (fn [mm]
               [:div {:style {:display :flex
                              :flex-direction :row
                              :flex-wrap :wrap
                              :align-items :center
                              :justify-content :center}}
                (map member-chip mm)])))

   [:div#member-biography
    ;; FIXME Ugly hack, so scrolling to biography isn't hidden by 50-px-high banner
    {:style {:margin-top -150
             :position :absolute
             :background-color :lime}}]
   (when-let [biography-entry @(re-frame/subscribe [:displayed-biography])]
     [:div {:style {:padding "0 250px"
                    :font-size 22
                    :text-align :justify}}
      [:p (str (t :who-we-are :biography-of) " ") (t :who-we-are biography-entry :name)]
      (map (fn [a] [:p a])
           (t :who-we-are biography-entry :biography))])])

(defn get-in-touch
  []
  [:section#get-in-touch {:style {:background-color styles/dark-strong
                                  :background-image "url(/img/map-image.png)"
                                  :width "100vw"
                                  :background-attachment :scroll
                                  :background-position :center
                                  :background-size :cover
                                  :display :flex
                                  :flex-direction :column
                                  :flex-wrap :wrap
                                  :align-items :center
                                  :justify-content :center}}
   [:header {:style {:display :flex
                     :flex-direction :column
                     :flex-wrap :wrap
                     :align-items :center}}
    [:h2 {:style {:color :white}} (t :get-in-touch :heading)]]
   [:a {:href "mailto:contact@pe2c.com"
        :style {:color :white
                :font-size 42}} "contact@pe2c.com"]])

(defn main-panel []
  [:div
   [sections]
   [:div#cover-image {:style {:background-image "url(/img/cover.jpg)"
                              :background-repeat :no-repeat
                              :background-attachment :scroll
                              :background-position :center
                              :background-size :cover
                              :width "100vw"
                              :min-height "100vh"
                              :display :flex
                              :flex-direction :row
                              :flex-wrap :wrap
                              :align-items :center
                              :justify-content :center
                              :position :relative
                              :top 0 #_(let [t (:scroll/y @(re-frame/subscribe [:window/scroll]))]
                                         ;; Parallax done right (in pure CSS):
                                         ;; https://keithclark.co.uk/articles/pure-css-parallax-websites/
                                         (/ t 2))}}
    [title]]
   [offer]
   [choose-us]
   [added-value]
   [who-we-are]
   [get-in-touch]])
