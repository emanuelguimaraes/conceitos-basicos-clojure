(ns conceitos-basicos-clojure.simbolos-condicionais)

; Definição de um símbolo
(def idade 18)

; Condicional para saber se a idade é maior ou igual a 18
(if (>= idade 18 )
  (println "Maior de idade")
  (println "Menor de idade"))

; Atualização do valor da idade para 15
(def idade 15)
(if (>= idade 18 )
  (println "Maior de idade")
  (println "Menor de idade"))