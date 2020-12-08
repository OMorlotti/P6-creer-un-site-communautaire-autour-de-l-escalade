package xyz.morlotti.escalade.models;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement // Pour gérer les @Transactional dans les DAO ???
@ImportResource({"classpath:hibernateConf.xml"})
public class HibernateConf
{
}
