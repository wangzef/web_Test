package com.bbs.dao;

import java.util.List;

import com.bbs.entity.Posts;

public interface Postsdao {
         public List<Posts> showpostsbyt_iddao(int t_id);  //�������ͱ����ʾ����
         public List<Posts> showallpostsdao();            //��ʾ��������
         public List<Posts> showpostsbyp_iddao(int p_id);   //�������ӱ����ʾ��������
         public boolean updatep_ntimedao(String p_ntime,int p_id);   //�޸��������¸���ʱ��
         public List<Posts> showpostbyt_iddao(int t_id);  //�������ͱ����ʾ�����͵�����
         public boolean addpostsdao(Posts posts);  //����
         public boolean deletepostsbyp_iddao(int p_id);  //�������ӱ��ɾ������
         public boolean updatep_statedao(int p_state,int p_id); //�޸�����״̬
         public boolean updatep_titlebyp_iddao(String p_title,int p_id);    //�������ӱ���޸����ӱ���
}
