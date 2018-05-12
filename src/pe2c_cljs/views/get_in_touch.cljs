(ns pe2c-cljs.views.get-in-touch
  (:require [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.locales :refer [t]]))

(defn section
  [id]
  [:section {:id id
             :style styles/get-in-touch-background-image}
   [:header {:style styles/flex-center}
    [:h2 {:style {:color :white}} (t :get-in-touch :heading)]]
   [:a#get-in-touch-link {:href "mailto:contact@pe2c.com"}
    "contact@pe2c.com"]])

