CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `produto` varchar(255) NOT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  `quantidade` float DEFAULT NULL,
  `descricao` varchar(255) NOT NULL,
  `foto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


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

CREATE TABLE `pedido` (
  `id` bigint(20) NOT NULL,
  `idCliente` bigint(20)  DEFAULT NULL,
  `data`  datetime NOT NULL,
  `sessao` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `pedidoitem` (
  `idProduto` bigint(20) NOT NULL,
  `idPedido` bigint(20)  NOT NULL,
  `descProduto` varchar(255) ,
  `valor` decimal(19,2) DEFAULT NULL,
  `quantidade` float DEFAULT NULL,
  `subtotal` decimal(19,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;