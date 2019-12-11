CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `produto` varchar(255) NOT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  `quantidade` float DEFAULT NULL,
  `descricao` varchar(255),
  `foto` varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `produto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

CREATE TABLE `cliente` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `rua` varchar(255) NOT NULL,
  `bairro` varchar(255),
  `cep` varchar(255) NOT NULL,
  `cidade` varchar(255),
  `estado` varchar(2) NOT NULL,
  `email` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `cliente`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL,
  `id_cliente` bigint(20) NOT NULL,
  `data`  datetime NOT NULL,
  `sessao` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `pedido`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
  
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_PEDIDO_CLIENTE` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`);
  

CREATE TABLE `pedidoitem` (
  `id` bigint(20) NOT NULL,
  `id_produto` bigint(20) NOT NULL,
  `id_pedido` bigint(20)  NOT NULL,
  `desc_produto` varchar(255) ,
  `valor` decimal(19,2) DEFAULT NULL,
  `quantidade` float DEFAULT NULL,
  `subtotal` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `pedidoitem`
  ADD CONSTRAINT `FK_PEDIDOITEM_PRODUTO` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id`);
  
ALTER TABLE `pedidoitem`
  ADD CONSTRAINT `FK_PEDIDOITEM_PEDIDO` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`);

ALTER TABLE `pedidoitem`
  ADD PRIMARY KEY (`id`);
  
ALTER TABLE `pedidoitem`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
