(ns pe2c-cljs.views.offer
  (:require [pe2c-cljs.subs]
            [pe2c-cljs.styles :as styles]
            [pe2c-cljs.locales :refer [t]]))

(defn opportunities
  []
  [:div {:style styles/padded-item}
   [:img {:alt ""
          :src "img/offer/recherche.png"
          :style styles/offer-picture}]
   [:h3 (t :offer :opportunity :heading)]
   [:p (t :offer :opportunity :text)]
   [:ul (doall (map (fn [bullet] ^{:key bullet} [:li bullet])
                    (t :offer :opportunity :bullets)))]])

(defn network
  []
  [:div {:style styles/padded-item}
   [:img {:alt ""
          :src "img/offer/teamup.png"
          :style styles/offer-picture}]
   [:h3 (t :offer :network :heading)]
   [:p (t :offer :network :text)]
   [:ul (doall (map (fn [bullet] ^{:key bullet} [:li bullet])
                    (t :offer :network :bullets)))]])

(defn follow-up
  []
  [:div {:style styles/padded-item}
   [:img {:alt ""
          :src "img/offer/network.png"
          :style styles/offer-picture}]

   [:h3 (t :offer :follow-up :heading)]
   [:p (t :offer :follow-up :text)]
   [:ul (doall (map (fn [bullet] ^{:key bullet} [:li bullet])
                    (t :offer :follow-up :bullets)))]])

(defn section
  [id]
  [:section {:id id}
   [:header {:style (assoc styles/flex-center
                      :flex-direction :column)}
    [:h2 (t :offer :heading)]
    [:div (t :offer :caption)]]
   [:div {:style (assoc styles/flex-center
                   :justify-content :space-between)}
    [opportunities]
    [network]
    [follow-up]]])
