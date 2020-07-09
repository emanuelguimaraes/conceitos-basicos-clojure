(ns conceitos-basicos-clojure.vetores)

(def precos [50 100 150])

; Criando um vetor para teste
(println precos)

; Obtendo o valor da posição 1 no vetor
(println (get precos 1))

; A função get possui um tratamento para ArrayIndexOutOfBounds
(println (get precos 4))

; Gerando uma nova lista (sem modificar a original) incrementando o valor do elemento 1
(println (update precos 1 inc))

; Gerando uma nova lista (sem modificar a original) decrementando o valor do elemento 1
(println (update precos 1 dec))

; Função Map
(println (map inc precos))

; Exemplo do uso da função Filter
(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-desconto (/ 10 100)
          desconto (* valor-bruto taxa-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(def mais-caro-que-100? #(> %1 100))
(println (valor-descontado mais-caro-que-100? 4000))

(println (filter mais-caro-que-100? precos))

; Combinação Map + Filter
(def multiplica-por-5 #(* %1 5))
(println (map multiplica-por-5 (filter mais-caro-que-100? precos)))

; Reduce (retornando a soma total da lista)
(println (reduce + precos))