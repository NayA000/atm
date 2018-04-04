package group.six.atm.dao;

import group.six.atm.entity.BussLog;

public interface BussLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BussLog record);

    int insertSelective(BussLog record);

    BussLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BussLog record);

    int updateByPrimaryKey(BussLog record);
}