(ns pe2c-cljs.views
  (:require [re-frame.core :as re-frame]
            [pe2c-cljs.subs]
            [pe2c-cljs.lorem-ipsum :as lorem-ipsum]
            [pe2c-cljs.locales :refer [t]]))

(defn- collapsible-sections
  []
  (let [collapsible-pred (fn [{:scroll/keys [y]}]
                           (let [threshold 50]
                             (if (<= y threshold)
                               :title/expanded
                               :title/collapsed)))
        collapsible-state (re-frame/subscribe [:window/scroll-trigger collapsible-pred])]
    (fn []
      (let [collapsible-style (case @collapsible-state
                                :title/collapsed {:background-color "#212529"
                                                  :position :fixed}
                                :title/expanded {:opacity 0
                                                 :position :fixed
                                                 :padding-top 25
                                                 :padding-bottom 25})]
        [:div#collapsible-title {:style (merge {:transition-property [:background-color :padding]
                                                :transition-duration "0.4s"
                                                :transition-delay "0s"
                                                :color :white
                                                :width "100%"
                                                :padding-left 200
                                                :padding-right 200
                                                :transition-timing-function "ease-in-out"}
                                               collapsible-style)}
         [:div.menu-item (t :menu-item :offer)]
         [:div.menu-item (t :menu-item :choose-us)]
         [:div.menu-item (t :menu-item :added-value)]
         [:div.menu-item (t :menu-item :who-we-are)]
         [:div.menu-item (t :menu-item :get-in-touch)]]))))

(defn title
  []
  [:div#landing-screen {:style {:display :flex
                                :flex-direction :column
                                :flex-wrap :wrap
                                :align-items :center
                                :justify-content :center
                                :color :white
                                :padding "30px 45px"}}
   [:h1 (t :title :title)]
   [:h1#landing-screen-sub-title (t :title :sub-title)]])

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
  [:section#offer
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
    :entry :geraud-de-boisset
    :position :associate}])

(defn who-we-are
  []
  [:section#who-we-are
   [:header {:style {:display :flex
                     :flex-direction :column
                     :flex-wrap :wrap
                     :align-items :center}}
    [:h2 (t :who-we-are :heading)]]

   [:div {:style {:display :flex
                  :flex-direction :row
                  :flex-wrap :wrap
                  :align-items :center
                  :justify-content :center}}
    (map (fn [member]
           [:div {:style {:margin 60}}
            [:img {:alt ""
                   :src (:img member)
                   :style {:object-fit :contain
                           :width 128
                           :height 128}}]
            [:div (t :who-we-are (:entry member) :name)]
            [:div (t :who-we-are (:position member))]])
         members)]])

(defn get-in-touch
  []
  [:section#get-in-touch
   [:header {:style {:display :flex
                     :flex-direction :column
                     :flex-wrap :wrap
                     :align-items :center}}
    [:h2 (t :get-in-touch :heading)]]
   [:a {:href "mailto:contact@pe2c.com"} "contact@pe2c.com"]])

(defn main-panel []
  [:div
   [:h1 "LOL"]
   #_[collapsible-sections]
   (let [scroll (re-frame/subscribe [:window/scroll])
         y (:scroll/y @scroll)]
     [:div {:style {:height "100vh"
                    :display :flex
                    :flex-direction :row
                    :flex-wrap :np-wrap
                    :align-items :flex-end}}
      [:div#cover-image {:style {:background-image "url(/img/cover.jpg)"
                                 :background-repeat :no-repeat
                                 :background-attachment :scroll
                                 :background-position :center
                                 :background-size :cover
                                 :width "100vw"
                                 :display :flex
                                 :flex-direction :row
                                 :flex-wrap :wrap
                                 :height (str "calc(100vh - " y "px)")
                                 :align-items :center
                                 :justify-content :center}}
       [title]]])
   [offer]
   [choose-us]
   [added-value]
   [who-we-are]
   [get-in-touch]])
