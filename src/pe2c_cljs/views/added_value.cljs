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
                   :width styles/added-value-list-height
                   :height styles/added-value-list-height}}]
    [:ol {:style {:height styles/added-value-list-height
                  :display :flex
                  :flex-direction :column
                  :justify-content :space-evenly}}
     (doall (map (fn [bullet] ^{:key bullet} [:li bullet])
                 (t :added-value :bullets)))]]])
