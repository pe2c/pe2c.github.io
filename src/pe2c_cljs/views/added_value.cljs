(ns pe2c-cljs.views.added-value
  (:require [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.locales :refer [t]]))

(defn section
  [id]
  [:section {:id id
             :style {;; this section is rather empty, it's not a
                     ;; problem to reduce its padding.
                     :padding-left (* 0.5 styles/section-padding)
                     :padding-right (* 0.5 styles/section-padding)}}
   [:header {:style styles/flex-center}
    [:h2 (t :added-value :heading)]]
   [:div {:style (assoc styles/flex-center
                   :flex-direction :row-reverse)}
    [:ol {:style {:height styles/added-value-list-height
                  :display :flex
                  :flex-direction :column
                  :justify-content :space-evenly}}
     (doall (map (fn [bullet] ^{:key bullet} [:li bullet])
                 (t :added-value :bullets)))]
    [:img {:alt ""
           :src "img/added-value/added-value.png"
           :style {:object-fit :contain
                   :width styles/added-value-list-height
                   :height styles/added-value-list-height}}]]])
