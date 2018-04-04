package group.six.atm.dao;

import group.six.atm.entity.ATM;

public interface ATMMapper {
    int deleteByPrimaryKey(Long ATM_ID);

    int insert(ATM record);

    int insertSelective(ATM record);

    ATM selectByPrimaryKey(Long ATM_ID);

    int updateByPrimaryKeySelective(ATM record);

    int updateByPrimaryKey(ATM record);
}