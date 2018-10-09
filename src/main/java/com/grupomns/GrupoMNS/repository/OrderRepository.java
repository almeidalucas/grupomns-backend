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
  public Integer insertOrderHeader(OrderHeader orderHeader) {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityManager.getTransaction().begin();

    LOGGER.info("Date: " + orderHeader.getDtNeg().toString());
    LOGGER.info("String formatted date: " + orderHeader.getFormatedDateDDMMYYY());

    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_APP_MNS.Ins_pedidocab")
        .registerStoredProcedureParameter("P_codemp", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_codparc", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_codvend", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_codtipoper", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_codtipvenda", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_dtneg", String.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_vlrnota", Float.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_codnat", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_codcencus", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_codproj", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_obs", String.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_statusnota", String.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_Numnota", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_ad_nuapp", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_codusu", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_nunota", Integer.class, ParameterMode.OUT)
        .setParameter("P_codemp", orderHeader.getCodEmp())
        .setParameter("P_codparc", orderHeader.getCodParc())
        .setParameter("P_codvend", orderHeader.getCodVend())
        .setParameter("P_codtipoper", orderHeader.getCodTipOper())
        .setParameter("P_codtipvenda", orderHeader.getCodTipVenda())
        .setParameter("P_dtneg", orderHeader.getFormatedDateDDMMYYY())
        .setParameter("P_vlrnota", orderHeader.getVlrNota())
        .setParameter("P_codnat", orderHeader.getCodNat())
        .setParameter("P_codcencus", orderHeader.getCodCencus())
        .setParameter("P_codproj", orderHeader.getCodProj())
        .setParameter("P_obs", orderHeader.getObservacao())
        .setParameter("P_statusnota", "L")
        .setParameter("P_Numnota", 0)
        .setParameter("P_ad_nuapp", orderHeader.getNuApp())
        .setParameter("P_codusu", orderHeader.getCodUsu());
    query.execute();
    entityManager.flush();

    Integer nuNota = Integer.valueOf(query.getOutputParameterValue("P_nunota").toString());

    entityTransaction.commit();
    entityManager.close();

    return nuNota;
  }

  @Transactional
  public void insertOrderProductList(Integer nuNota, List<ProductHeader> productHeaderList) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();

    for (ProductHeader productHeader :
        productHeaderList) {
      StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_APP_MNS.Ins_Pedidoitens")
          .registerStoredProcedureParameter("P_NUNOTA", Integer.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_CODPROD", Integer.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_QTDNEG", Float.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_CODVOL", String.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_CONTROLE", String.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_VLRUNIT", Float.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_VLRTOTAL", Float.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_ADCODPROJ", Integer.class, ParameterMode.IN)
          .setParameter("P_NUNOTA", nuNota)
          .setParameter("P_CODPROD", productHeader.getCod())
          .setParameter("P_QTDNEG", productHeader.getQtdItens())
          .setParameter("P_CODVOL", productHeader.getCodVol())
          .setParameter("P_CONTROLE", productHeader.getControle())
          .setParameter("P_VLRUNIT", productHeader.getVlrUnit())
          .setParameter("P_VLRTOTAL", productHeader.getVlrTotal())
          .setParameter("P_ADCODPROJ", productHeader.getAdCodProj());

      query.execute();
    }

    entityManager.flush();
    entityTransaction.commit();
    entityManager.close();
  }
}
