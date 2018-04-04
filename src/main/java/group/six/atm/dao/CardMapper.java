package group.six.atm.dao;

import group.six.atm.entity.Card;

public interface CardMapper {
    int deleteByPrimaryKey(String cardNumber);

    int insert(Card record);

    int insertSelective(Card record);

    Card selectByPrimaryKey(String cardNumber);

    int updateByPrimaryKeySelective(Card record);

    int updateByPrimaryKey(Card record);
}