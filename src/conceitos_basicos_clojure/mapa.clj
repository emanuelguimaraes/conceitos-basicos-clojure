(ns conceitos-basicos-clojure.mapa)

; Definindo uma coleção mapa chamado "estoque"
(def estoque {:mochila 3, :camiseta 9})
(println estoque)

; Utilizando a função "count" da coleção para verificar o total de itens existente
(println "Total:" (count estoque))

; Utilizando a função "keys" para obter todas as chaves da coleção
(println "Chaves:" (keys estoque))

; Utilizando a função "vals" para obter todos os valores da coleção
(println "Valores:" (vals estoque))

; Manipulando a coleção, adicionando um novo elemento
(println (assoc estoque :cadeira 20))
(println estoque)

; Atualizar um valor de um elemento existente na coleção
(println (update estoque :mochila + 15))

; Manipulando a coleção, removendo o elemento "mochila"
(println (dissoc estoque :mochila))

; Definindo um mapa aninhado chamado "pedido"
(def pedido {:mochila { :quantidade 10, :preco 50}
             :camiseta {:quantidade 50, :preco 10}})

; Exemplo de Threading First
; Imprimindo a quantidade de mochilas existentes no pedido
(println "Quantidade" (-> pedido
                          :mochila
                          :quantidade))

; Utilizando a função map na coleção "pedido"
(defn preco-dobrado
  [[_ val]]
  (* (:preco val) 2))

; Imprimindo o preço dos itens existentes no pedido dobrados
(println "Valor do itens dobrados" (map preco-dobrado pedido))

; Imprimindo o valor total do pedido dobrado
(println "Valor total dos itens dobrados" (reduce + (map preco-dobrado pedido)))

; Realizando a mesma operação acima, porém utilizando Threading Last (->>)
; Onde ao invés de retornar o símbolo no ínicio, ele retorna no fim
(defn preco-dobrado-produto
  [produto]
  (* (:preco produto) 2))

(defn valor-total-pedidos
  [pedido]
  (->> pedido
       vals
      (map preco-dobrado-produto)
      (reduce +)))

(println "Valor total dos itens dobrados (threading)" (valor-total-pedidos pedido))

; Utilizando a função filter na coleção "pedido"
(def pedido {:mochila { :quantidade 10, :preco 50}
             :camiseta {:quantidade 50, :preco 10}
             :calsa {:preco 100}
             :casaco {:quantidade 0 :preco 150}})

(defn produto-disponivel?
  [produto]
  (> (get produto :quantidade 0) 0))

(println (filter produto-disponivel? (vals pedido)))