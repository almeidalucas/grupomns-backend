package com.grupomns.GrupoMNS.repository;

import com.grupomns.GrupoMNS.entity.ErrorMessage;
import com.grupomns.GrupoMNS.entity.OrderHeader;
import com.grupomns.GrupoMNS.entity.ProductHeader;
import com.grupomns.GrupoMNS.entity.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
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
  public void removeOrder(Integer nuNota) throws ErrorMessage {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityManager.getTransaction().begin();

    LOGGER.info("removeOrder: " + nuNota);

    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_APP_MNS.DEL_PEDIDOCAB")
        .registerStoredProcedureParameter("P_NUNOTA", Integer.class, ParameterMode.IN)
        .registerStoredProcedureParameter("P_MSG", String.class, ParameterMode.OUT)
        .setParameter("P_NUNOTA", nuNota);
    query.execute();
    entityManager.flush();

    if (query.getOutputParameterValue("P_MSG") != null)
      throw new ErrorMessage("500", "Erro ao deletar pedido " + nuNota + " - " +query.getOutputParameterValue("P_MSG"), null);

    entityTransaction.commit();
    entityManager.close();
  }

  @Transactional
  public Integer insertOrderHeader(OrderHeader orderHeader) throws ErrorMessage {

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityManager.getTransaction().begin();

    LOGGER.info("Date: " + orderHeader.getDtNeg().toString());
    LOGGER.info("String formatted date: " + orderHeader.getFormattedDateDDMMYYYY());

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
      throw new ErrorMessage("500", "Erro ao inserir cabeçalho " + query.getOutputParameterValue("P_MSG"), null);

    entityTransaction.commit();
    entityManager.close();

    return nuNota;
  }

  @Transactional
  public ResponseMessage insertOrderProductList(Integer nuNota, List<ProductHeader> productHeaderList) throws ErrorMessage {
    StringBuilder message = new StringBuilder();

    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();

    List<ProductHeader> productHeaderListToRemove = new ArrayList<>();

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
          .registerStoredProcedureParameter("P_QTDNEG", Float.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_CODVOL", String.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_CONTROLE", String.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_VLRUNIT", Float.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_VLRTOTAL", Float.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_ADCODPROJ", Integer.class, ParameterMode.IN)
          .registerStoredProcedureParameter("P_MSG", String.class, ParameterMode.OUT)
          .setParameter("P_NUNOTA", nuNota)
          .setParameter("P_CODPROD", productHeader.getCod())
          .setParameter("P_QTDNEG", productHeader.getQtdItens())
          .setParameter("P_CODVOL", productHeader.getCodVol())
          .setParameter("P_CONTROLE", productHeader.getControle())
          .setParameter("P_VLRUNIT", productHeader.getVlrUnit())
          .setParameter("P_VLRTOTAL", productHeader.getVlrTotal())
          .setParameter("P_ADCODPROJ", productHeader.getAdCodProj());

      query.execute();

      if (query.getOutputParameterValue("P_MSG") != null) {
        message.append(query.getOutputParameterValue("P_MSG").toString()).append(" - ").append(productHeader.getDescricao());
        productHeaderListToRemove.add(productHeader);
      } else {
        productHeader.setNuNota(nuNota);
      }
    }

    productHeaderList.removeAll(productHeaderListToRemove);

    entityManager.flush();
    entityTransaction.commit();
    entityManager.close();

    if (!message.toString().isEmpty()) {
      return new ResponseMessage("500", "Erro ao inserir produtos - " + message, productHeaderList);
    }

    return new ResponseMessage("200", "Pedido " + nuNota + " inserido com sucesso!", productHeaderList);
  }

  @Transactional
  public void geraRateio(Integer nuNota) {
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction entityTransaction = entityManager.getTransaction();
    entityTransaction.begin();

    StoredProcedureQuery query = entityManager.createStoredProcedureQuery("STP_GERA_RATEIO_CAB_MNS")
        .registerStoredProcedureParameter("P_NUNOTA", Integer.class, ParameterMode.IN)
        .setParameter("P_NUNOTA", nuNota);

    query.execute();
    entityManager.flush();
    entityTransaction.commit();
    entityManager.close();
  }
}
