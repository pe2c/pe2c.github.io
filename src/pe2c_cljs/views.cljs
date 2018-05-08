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
                                :title/expanded {:position :fixed
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
  [:div {:style {:display :flex
                 :flex-direction :column
                 :flex-wrap :wrap
                 :align-items :center
                 :justify-content :center
                 :color :white}}
   [:h1 (t :title :title)]
   [:h1 (t :title :sub-title)]])

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
    [:div {:style {:margin 60}}
     [:img {:alt ""
            :src "img/team/geraud-de-boisset.jpg"
            :style {:object-fit :contain
                    :width 128
                    :height 128}}]
     [:div (t :who-we-are :geraud-de-boisset :name)]
     [:div (t :who-we-are :president-associate)]]

    [:div {:style {:margin 60}}
     [:img {:alt ""
            :src "img/team/arnaud-ladrange.jpg"
            :style {:object-fit :contain
                    :width 128
                    :height 128}}]
     [:div (t :who-we-are :arnaud-ladrange :name)]
     [:div (t :who-we-are :associate)]]

    [:div {:style {:margin 60}}
     [:img {:alt ""
            :src "img/team/pierre-niclot.jpg"
            :style {:object-fit :contain
                    :width 128
                    :height 128}}]
     [:div (t :who-we-are :pierre-niclot :name)]
     [:div (t :who-we-are :associate)]]

    [:div {:style {:margin 60}}
     [:img {:alt ""
            :src "img/team/michel-ravet.jpg"
            :style {:object-fit :contain
                    :width 128
                    :height 128}}]
     [:div (t :who-we-are :michel-ravet :name)]
     [:div (t :who-we-are :associate)]]]

   [:div#bio-geraud-de-boisset
    (map (fn [paragraph] [:p paragraph])
         (t :who-we-are :geraud-de-boisset :biography))]

   [:div#bio-arnaud-ladrange
    (map (fn [paragraph] [:p paragraph])
         (t :who-we-are :arnaud-ladrange :biography))]

   [:div#bio-pierre-niclot
    (map (fn [paragraph] [:p paragraph])
         (t :who-we-are :pierre-niclot :biography))]

   [:div#bio-michel-ravet
    (map (fn [paragraph] [:p paragraph])
         (t :who-we-are :michel-ravet :biography))]])

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
   [collapsible-sections]
   [:div#cover-image {:style {:display :flex
                              :flex-direction :row
                              :flex-wrap :wrap
                              :align-items :center
                              :justify-content :center}}
    [title]]

   [offer]
   [choose-us]
   [added-value]
   [who-we-are]
   [get-in-touch]])
