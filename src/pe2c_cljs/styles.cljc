(ns pe2c-cljs.styles
  #?(:clj
           (:require [garden.def :refer [defstyles]])
     :cljs (:require-macros [garden.def :refer [defstyles]])))

(def logo-blue-light "#80ACD1")
(def logo-blue-strong "#0068A3")
(def logo-green-light "#ECF4D8")
(def logo-green-strong "#9AC446")
(def dark-strong "#212529")

(defstyles sheet
           [:a {:text-decoration :none}]
  [:body {:margin 0
          :scroll-behavior :smooth}]
  [:h1 :h2 :h3 :h4 {:font-family "'Open Sans', sans-serif"
                    :color logo-blue-strong}]
  [:h2 {:font-size "32px"}]
  [:p :div :li {:font-family "'Montserrat', sans-serif"}]
  [:#landing-screen [:#landing-screen-sub-title {:font-size "80px"}]]
  [:.menu-item {:margin "15px"}]
  [:.menu-item:hover {:color :white}]
  [:#collapsible-title {}]
  [:div#cover-image {}]
  ["section:nth-child(2n)" {:background-color (str logo-blue-light "18")}])
