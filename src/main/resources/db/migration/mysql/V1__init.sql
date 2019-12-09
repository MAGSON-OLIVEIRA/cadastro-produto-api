CREATE TABLE `empresa` (
  `id` bigint(20) NOT NULL,
  `categoria` varchar(255) NOT NULL,
  `produto` varchar(255) NOT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  `quantidade` float DEFAULT NULL,
  `descricao` varchar(255) NOT NULL,
  `foto` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

