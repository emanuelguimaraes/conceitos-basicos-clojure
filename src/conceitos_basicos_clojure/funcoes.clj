(ns conceitos-basicos-clojure.funcoes)

; Definição de função
(defn valor-descontado
  "Retorna o valor com desconto de 10% se o valor bruto for estritamente maior que 100."
  [aplica? valor-bruto]
  (if (aplica? valor-bruto)
    (let [taxa-desconto (/ 10 100)
          desconto (* valor-bruto taxa-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

; Exemplo de função anonima
(println (valor-descontado (fn ([valor-bruto] (> valor-bruto 100))) 9000))

; Exemplo de função lambda
(println (valor-descontado #(> %1 100) 5000))

; Boa prática que deixa o código legivel e faz uso das funções anonimas/lambda
(def mais-caro-que-100? #(> %1 100))
(println (valor-descontado mais-caro-que-100? 4000))