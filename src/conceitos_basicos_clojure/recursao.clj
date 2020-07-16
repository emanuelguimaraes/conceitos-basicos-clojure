(ns conceitos-basicos-clojure.recursao)

; Exemplo de implementação do "map"
(defn example-map
  [function sequence]
  (let [first-element (first sequence)]
  (if (not (nil? first-element))
    (do
      (function first-element)
      (recur function (next sequence))))))

; O termo "recur" indica para o Clojure para transformar
; essa recursão em um laço otimizado

(example-map println ["Emanuel", "Yohanna", "Raje", "Frida"])

(def list-int [1, 2, 3, 4, 5])
(def dobra-valor #(println (* %1 2)))
(example-map dobra-valor list-int)