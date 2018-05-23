(ns pe2c-cljs.views.added-value
  (:require [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.locales :refer [t]]))

(defn section
  [id]
  [:section {:id id
             :style styles/added-value-background-image}
   [:div {:style {:background-color "#FFFFFFDD"
                  :padding styles/length-unit}}
    [:header {:style styles/flex-center}
     [:h2 (t :added-value :heading)]]
    [:ol#added-value-ol
     (doall (map (fn [bullet] ^{:key bullet} [:li#added-value-li bullet])
                 (t :added-value :bullets)))]]])
