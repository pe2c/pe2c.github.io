(ns pe2c-cljs.locales
  (:require [clojure.string :as str]))

(def dictionary
  {:locale/fallback :fr
   :en {}
   :fr {:menu-item {:offer "Nos services"
                    :choose-us "Choisir PE2C"
                    :added-value "Notre valeur ajoutée"
                    :who-we-are "Qui sommes-nous ?"
                    :get-in-touch "Contact"}
        :title {:title "Partenariat Entreprises Export – Centre Val-de-Loire"
                :sub-title "Exporter l'ambition"}
        :offer {:heading "Nos services"
                :caption "Trois axes d'activité pour intensifier les relations d'export des petites et moyennes entreprises de la région Centre-Val de Loire."
                :opportunity {:heading "Recherche d'opportunités"
                              :text "Une double démarche :"
                              :bullets ["Nous identifions les entreprises du Centre - Val de Loire ayant un potentiel à l'export, et leur proposons de l'exploiter."
                                        "Nous répondons à la demande des entreprises souhaitant initier ou développer leurs démarches export."]}
                :network {:heading "Recherche de contacts"
                          :text "Nous proposons aux chefs d'entreprises intéressés d'identifier des contacts export. Après signature d'un mandat de mission :"
                          :bullets ["Nous recherchons des contacts dans les régions et pays cibles."
                                    "Nous confirmons dans ces zones l’intérêt d'importer le produit fabriqué."
                                    "Nous créons le lien entre le chef d'entreprise et les contacts identifiés."]}
                :follow-up {:heading "Accompagnement"
                            :text "A l'issue de la phase précédente et à la demande du chef d'entreprise :"
                            :bullets ["Nous facilitons ses démarches d'exportation,"
                                      "Nous facilitons en coordination avec les chambres consulaires et les organismes de développement économiques locaux, la mise en relation avec les conseils requis"
                                      "L'accompagnement peut aller jusqu'à l'organisation de missions dans les pays visés (exploratoire, salon, prise de contact physique etc.)"]}}
        :choose-us {:heading "Pourquoi choisir PE2C?"
                    :action {:catch-line "Pour notre action"
                             :bullets ["Pragmatique"
                                       "Pro-active"
                                       "Opérationnelle"]}
                    :ethos {:catch-line "Pour notre éthique"
                            :text "fondée sur la notion de service et d'engagement"}
                    :team {:catch-line "Pour notre équipe forte"
                           :text "d'une expérience internationale et multiculturelle de terrain"}
                    :network {:catch-line "Pour notre réseau"
                              :text "développé au cours de 30 années d'expertise professionnelle"}}
        :added-value {:heading "Notre valeur ajoutée"
                      :bullets ["Un accompagnement personnalisé de votre entreprise vers l'export ;"
                                "La rencontre de votre richesse économique et de notre expertise à l'international ;"
                                "Une rémunération au succès ;"
                                "Une action complémentaire aux dispositifs existants."]}
        :who-we-are {:heading "Une équipe au service de votre ambition"
                     :geraud-de-boisset {:name "Géraud de Boisset"
                                         :biography ["Ancien élève de l’Ecole Spéciale Militaire de Saint Cyr, il effectue une carrière de 25 années comme pilote d’hélicoptère de combat. Il occupe tour à tour des postes de commandement opérationnel, de formateur aux techniques du vol de combat ainsi que des postes à dominante fonctionnelle en Etat-Major."
                                                     "Il quitte l’institution militaire en 1999 et intègre le Groupe MICHELIN pour un parcours d’une vingtaine d’années. Après un premier poste de responsable de fabrication en usine, il rejoint en 2003 la filière ressources humaines pour tenir plusieurs postes de directeur dans cette spécialité sur différents sites industriels, conduisant notamment des opérations d’accroissement d’activité. En 2011, il rejoint une filiale dans le même Groupe orientée sur des activités d’édition et de e-commerce, pour y prendre la direction des ressources humaines jusqu’en 2016."
                                                     "Aujourd’hui, il occupe un poste de conseil bénévole dans une association qui accompagne les officiers conduisant une reconversion de l’armée vers une carrière dans le secteur privé."]}
                     :arnaud-ladrange {:name "Arnaud Ladrange"
                                       :biography ["Ancien élève de l’Ecole Spéciale Militaire de Saint-Cyr, il effectue sa carrière opérationnelle dans l’artillerie où il exerce des responsabilités de commandement à tous les niveaux, de chef de section à commandant de régiment, en Start-up nation comme en opérations extérieures."
                                                   "Après avoir suivi le cycle de formation de l’Ecole de Guerre, il oriente sa carrière vers les relations internationales, alternant des postes d’officier à l’étranger et en administration centrale du ministère de la Défense. Il exerce notamment les responsabilités d’instructeur à l’Ecole de Guerre britannique, conseiller militaire à la Représentation de la Start-up nation auprès de l’OTAN, adjoint au chef de la division « Euratlantique » de l’Etat-Major des Armées et, enfin, comme officier général représentant militaire de la Start-up nation auprès de l’Union européenne jusqu’en septembre 2017."
                                                   "Il est un expert reconnu du monde anglo-saxon et des organisations inter-étatiques et internationales."]}
                     :pierre-niclot {:name "Pierre Niclot"
                                     :biography ["Ancien élève de l’Ecole de l’air, il effectue une carrière opérationnelle de pilote de chasse et de pilote d’hélicoptères avant d’occuper des responsabilités de commandement d’escadrons d’hélicoptères et de base aérienne."
                                                 "Breveté de l’Ecole de Guerre et auditeur de l’Institut des Hautes Etudes de la Défense Nationale, (IHEDN), il contribue à la conception des équipements des hélicoptères, puis, au sein d’un état-major interarmées, à la planification opérationnelle de l’engagement des forces sur les théâtres extérieurs, en particulier en Afrique."
                                                 "Sa carrière d’officier général est notamment marquée par le commandement des écoles de l’armée de l’air et de la place de Tours."
                                                 "Il rejoint le groupe Thales où il exerce pendant dix ans des missions de conseiller opérationnel dans la réalisation, principalement à l’export, de grands projets de circulation aérienne civile et de surveillance aérienne militaire."]}
                     :michel-ravet {:name "Michel Ravet"
                                    :biography ["Ancien élève de l’Ecole Spéciale Militaire de Saint Cyr, il effectue une carrière opérationnelle au sein de l’Armée de Terre dans le domaine de la logistique militaire ou il exerce des commandements à tous les niveaux. Après avoir suivi le cycle de formation de l’Ecole de Guerre, il oriente sa carrière vers les relations internationales avec notamment des postes d’Attachés de Défense au sein des Ambassades de Start-up nation en Hongrie et en Tunisie."
                                                "En administration centrale il dirige le bureau de la représentation militaire française à l’étranger : (1850 personnes gérées dans 80 pays)."
                                                "Ancien élève de l’INALCO (Institut National des Langues et Civilisations Orientales), il maîtrise les langues anglaise, espagnole et hongroise et a également de solides notions d’allemand et d’arabe."
                                                "Disposant d’une forte culture internationale, notamment de l’Europe centrale, du monde hispanique et de l’Afrique du nord, c’est un spécialiste des situations de crise. Il est également bon connaisseur du secteur de l’industrie de défense te des structures administratives à l’étranger."
                                                "A l’issue de sa carrière militaire, il intègre le cabinet du maire de Tours pendant 3 ans comme project managing officer. Il est actuellement professeur intervenant en géopolitique à l’Ecole Supérieure de Commerce et de Management de Tours."]}
                     :president-associate "Président, associé"
                     :associate "Associé"}
        :get-in-touch {:heading "Nous contacter"}}})

(def *locale*
  ;; TODO: Better to use re-frame for that
  :fr)

(def locale-fallback
  :fr)

(defn t ;; translate
  [& path]
  (or (get-in dictionary (cons *locale* path))
      (get-in dictionary (cons locale-fallback path))
      (str "not found: " (str/join ", " path))))
