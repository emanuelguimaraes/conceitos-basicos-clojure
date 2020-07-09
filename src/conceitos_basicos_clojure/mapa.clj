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