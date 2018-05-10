(ns pe2c-cljs.styles
  #?(:clj (:require [garden.def :refer [defstyles]])
     :cljs (:require-macros [garden.def :refer [defstyles]])))

(defstyles sheet
  [:body {:margin 0}]
  [:h1 :h2 :h3 :h4 {:font-family "'Open Sans', sans-serif"}]
  [:p :div :li {:font-family "'Montserrat', sans-serif"}]
  [:#landing-screen [:#landing-screen-sub-title {:font-size "80px"}]]
  [:#landing-screen {:background-color :red
                     :line-height "50px"}]
  [:.menu-item {:margin "15px"}]
  [:.menu-item:hover {:color :red}]
  [:#collapsible-title {:top 0
                        :right 0
                        :display :flex
                        :flex-wrap :wrap
                        :flex-direction :row
                        :justify-content :flex-end}]
  [:div#cover-image {}])
