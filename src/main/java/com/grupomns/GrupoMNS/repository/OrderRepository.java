package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.OrderHeader;
import com.grupomns.GrupoMNS.entity.ProductHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class OrderRepository {

  private final EntityManagerFactory entityManagerFactory;

  private final static Logger LOGGER = Logger.getLogger(OrderRepository.class.getName());

  @Autowired
  public OrderRepository(EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
  }

  @Transactional
  public Integer insertOrderHeader(OrderHeader orderHeader) throws Exception {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityManager.getTransaction().begin();

    LOGGER.info("Date: " + orderHeader.getDtNeg().toString());
    LOGGER.info("String formatted date: " + orderHeader.getFormatedDateDDMMYYY());

    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_APP_MNS.Ins_pedidocab")
        .registerStoredProcedureParameter("P_CODEMP", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_CODPARC", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_CODVEND", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_CODTIPOPER", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_CODTIPVENDA", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_DTNEG", Date.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_VLRNOTA", Float.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_CODNAT", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_CODCENCUS", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_CODPROJ", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_OBS", String.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_STATUSNOTA", String.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_NUMNOTA", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_AD_NUAPP", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_NUNOTA", Integer.class, ParameterMode.OUT)
        .registerStoredProcedureParameter("P_MSG", String.class, ParameterMode.OUT)
        .setParameter("P_CODEMP", orderHeader.getCodEmp())
        .setParameter("P_CODPARC", orderHeader.getCodParc())
        .setParameter("P_CODVEND", orderHeader.getCodVend())
        .setParameter("P_CODTIPOPER", orderHeader.getCodTipOper())
        .setParameter("P_CODTIPVENDA", orderHeader.getCodTipVenda())
        .setParameter("P_DTNEG", orderHeader.getDtNeg())
        .setParameter("P_VLRNOTA", orderHeader.getVlrNota())
        .setParameter("P_CODNAT", orderHeader.getCodNat())
        .setParameter("P_CODCENCUS", orderHeader.getCodCencus())
        .setParameter("P_CODPROJ", orderHeader.getCodProj())
        .setParameter("P_OBS", orderHeader.getObservacao())
        .setParameter("P_STATUSNOTA", "L")
        .setParameter("P_NUMNOTA", 0)
        .setParameter("P_AD_NUAPP", orderHeader.getNuApp());
    query.execute();
    entityManager.flush();

    Integer nuNota = Integer.valueOf(query.getOutputParameterValue("P_NUNOTA").toString());
    if (query.getOutputParameterValue("P_MSG") != null)
      throw new Exception("Erro ao inserir cabeçalho " + query.getOutputParameterValue("P_MSG"));

    entityTransaction.commit();
    entityManager.close();

    return nuNota;
  }

  @Transactional
  public void insertOrderProductList(Integer nuNota, List<ProductHeader> productHeaderList) throws Exception {
    StringBuilder message = new StringBuilder();

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();

    for (ProductHeader productHeader :
        productHeaderList) {
      LOGGER.info("P_NUNOTA: " + nuNota);
      LOGGER.info("P_CODPROD: " + productHeader.getCod());
      LOGGER.info("P_QTDNEG: " + productHeader.getQtdItens());
      LOGGER.info("P_CODVOL: " + productHeader.getCodVol());
      LOGGER.info("P_CONTROLE: " + productHeader.getControle());
      LOGGER.info("P_VLRUNIT: " + productHeader.getVlrUnit());
      LOGGER.info("P_VLRTOTAL: " + productHeader.getVlrTotal());
      LOGGER.info("P_ADCODPROJ: " + productHeader.getAdCodProj());
      StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_APP_MNS.Ins_Pedidoitens")
          .registerStoredProcedureParameter("P_NUNOTA", Integer.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_CODPROD", Integer.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_QTDNEG", Double.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_CODVOL", String.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_CONTROLE", String.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_VLRUNIT", Double.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_VLRTOTAL", Double.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_ADCODPROJ", Integer.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_MSG", String.class, ParameterMode.OUT)
          .setParameter("P_NUNOTA", 248630)
          .setParameter("P_CODPROD", 5861)
          .setParameter("P_QTDNEG", 2.0)
          .setParameter("P_CODVOL", "UN")
          .setParameter("P_CONTROLE", " ")
          .setParameter("P_VLRUNIT", 2.0)
          .setParameter("P_VLRTOTAL", 4.0)
          .setParameter("P_ADCODPROJ", 35010301);

      query.execute();

      if (query.getOutputParameterValue("P_MSG") != null) {
        message.append(query.getOutputParameterValue("P_MSG").toString()).append(" ").append(productHeader.getDescricao());
//        productHeaderList.remove(productHeader);
      }
    }

    entityManager.flush();
    entityTransaction.commit();
    entityManager.close();

    if (!message.toString().isEmpty()) {
      throw new Exception("Erro ao inserir produtos" + message);
    }
  }
}
