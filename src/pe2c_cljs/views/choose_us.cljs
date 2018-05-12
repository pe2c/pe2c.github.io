(ns pe2c-cljs.views.choose-us
  (:require [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.locales :refer [t]]))

(defn section
  [id]
  [:section {:id id}
   [:header {:style styles/flex-center}
    [:h2 (t :choose-us :heading)]]

   [:div {:style {:display :flex
                  :flex-direction :row
                  :flex-wrap :wrap}}
    [:div {:style (assoc styles/padded-item
                    :display :flex
                    :flex-direction :column
                    :flex-wrap :wrap)}
     [:div
      [:p (t :choose-us :action :catch-line)]
      [:ul (doall (map (fn [bullet] ^{:key bullet} [:li bullet])
                       (t :choose-us :action :bullets)))]]

     [:p [:span {:style {:font-weight :bold}} (t :choose-us :ethos :catch-line)] (t :choose-us :ethos :text)]]
    [:div {:style styles/padded-item}
     "put a picture here"]
    [:div {:style (assoc styles/padded-item
                    :display :flex
                    :flex-direction :column
                    :flex-wrap :wrap)}
     [:p [:span {:style {:font-weight :bold}} (t :choose-us :team :catch-line)] (t :choose-us :team :text)]
     [:p [:span {:style {:font-weight :bold}} (t :choose-us :network :catch-line)] (t :choose-us :network :text)]]]])
