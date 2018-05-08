(ns pe2c-cljs.styles
  #?(:clj (:require [garden.def :refer [defstyles]])
     :cljs (:require-macros [garden.def :refer [defstyles]])))

(defstyles sheet
  [:body {:margin 0}]
  [:.menu-item {:margin "15px"}]
  [:.menu-item:hover {:color :red}]
  [:#collapsible-title {:top 0
                        :right 0
                        :display :flex
                        :flex-wrap :wrap
                        :flex-direction :row
                        :justify-content :flex-end}]
  [:div#cover-image {:background-image "url(/img/cover.jpg)"
                     :background-repeat :no-repeat
                     :background-attachment :scroll
                     :background-position :center
                     :background-size :cover
                     :width "100vw"
                     :height "100vh"}])
