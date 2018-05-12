(ns pe2c-cljs.views
  (:require [pe2c-cljs.db :as db]
            [pe2c-cljs.locales :refer [t]]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.subs]
            [pe2c-cljs.views.added-value :as added-value]
            [pe2c-cljs.views.choose-us :as choose-us]
            [pe2c-cljs.views.get-in-touch :as get-in-touch]
            [pe2c-cljs.views.offer :as offer]
            [pe2c-cljs.views.who-we-are :as who-we-are]
            [re-frame.core :as re-frame]))

(def sections
  [#:section{:href "offer"
             :panel-title (t :menu-item :offer)
             :view offer/section}
   #:section{:href "choose-us"
             :panel-title (t :menu-item :choose-us)
             :view choose-us/section}
   #:section{:href "added-value"
             :panel-title (t :menu-item :added-value)
             :view added-value/section}
   #:section{:href "who-we-are"
             :panel-title (t :menu-item :who-we-are)
             :view who-we-are/section}
   #:section{:href "get-in-touch"
             :panel-title (t :menu-item :get-in-touch)
             :view get-in-touch/section}])

(defn collapsible-sections-pred
  [{:scroll/keys [y]}]
  (let [threshold styles/section-collapsed-height]
    (if (<= y threshold)
      :sections/expanded
      :sections/collapsed)))

(defn- sections-panel
  []
  (let [collapsible-state (re-frame/subscribe [:window/scroll-trigger collapsible-sections-pred])
        menu-item-color (case @collapsible-state
                          :sections/collapsed styles/logo-blue-light
                          :sections/expanded :white)]
    [:div {:style (merge (case @collapsible-state
                                             :sections/collapsed styles/section-collapsed
                                             :sections/expanded styles/section-expanded)
                         styles/section-base
                         styles/flex-center)}
     (map (fn [{:section/keys [panel-title href] :as section}]
            ^{:key section}
            [:a.menu-item {:style {:color menu-item-color
                                   :margin 15}
                           :href (str "#" href)}
             panel-title])
          sections)]))

(defn title
  []
  [:div#title {:style (assoc styles/flex-center
                  :flex-direction :row)}
   [:div {:style (merge styles/flex-center
                        {:flex-direction :row}
                        styles/title-transition)}
    [:img#title-logo {:alt "Logo of PE2C"
                      :src "img/logos/pe2c.svg"
                      :style styles/title-logo}]
    [:div {:style {:display :flex
                   :flex-direction :column
                   :justify-content :flex-end
                   :align-items :flex-end
                   :padding "30px 45px"}}
     [:h1#title-name (t :title :title)]
     [:h1#title-motto (t :title :sub-title)]]]])

(defn main-panel
  []
  [:div
   [sections-panel]
   [:div {:style (merge styles/flex-center
                        styles/cover-background-image
                        {:min-height "100vh"}
                        ;; Parallax done right (in pure CSS):
                        ;; https://keithclark.co.uk/articles/pure-css-parallax-websites/
                        )}
    [title]]
   [:div {:style (assoc styles/flex-center
                   :align-items :stretch
                   :flex-direction :column)}
    (doall (map (fn [{:section/keys [href view]}]
                  ^{:key view} [view href])
                sections))]])
