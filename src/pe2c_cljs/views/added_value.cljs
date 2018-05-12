(ns pe2c-cljs.views.added-value
  (:require [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.locales :refer [t]]))

(defn section
  [id]
  [:section {:id id}
   [:header {:style styles/flex-center}
    [:h2 (t :added-value :heading)]]
   [:div {:style styles/flex-center}
    [:img {:alt ""
           :src "img/added-value/added-value.png"
           :style {:object-fit :contain
                   :width "20%"
                   :height "20%"}}]
    [:ol (doall (map (fn [bullet] ^{:key bullet} [:li bullet])
                     (t :added-value :bullets)))]]])
