(ns pe2c-cljs.views.choose-us
  (:require [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.locales :refer [t]]))

(defn section
  [id]
  [:section {:id id
             :style styles/choose-us-background-image}
   [:div#reasons
    [:header {:style styles/flex-center}
     [:h2 (t :choose-us :heading)]]
    [:div {:style styles/flex-center}
     [:div#reason
      [:p {:style {:font-weight :bold}} (t :choose-us :action :catch-line)]
      [:ul (doall (map (fn [bullet] ^{:key bullet} [:li bullet])
                       (t :choose-us :action :bullets)))]]
     [:p#reason [:span {:style {:font-weight :bold}} (t :choose-us :ethos :catch-line) " "] (t :choose-us :ethos :text)]
     [:p#reason [:span {:style {:font-weight :bold}} (t :choose-us :team :catch-line) " "] (t :choose-us :team :text)]
     [:p#reason [:span {:style {:font-weight :bold}} (t :choose-us :network :catch-line) " "] (t :choose-us :network :text)]]]])
