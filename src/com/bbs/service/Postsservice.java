package com.bbs.service;

import java.util.List;

import com.bbs.entity.Posts;

public interface Postsservice {
    public List<Posts> showpostsbyt_idservice(int t_id);  //�������ͱ����ʾ����
    public List<Posts> showallpostsservice();            //��ʾ��������
    public List<Posts> showpostsbyp_idservice(int p_id);   //�������ӱ����ʾ��������
    public boolean updatep_ntimeservice(String p_ntime,int p_id);   //�޸��������¸���ʱ��
    public List<Posts> showpostbyt_idservice(int t_id);  //�������ͱ����ʾ�����͵�����
    public boolean addpostsdao(Posts posts);  //����
    public boolean deletepostsbyp_idservice(int p_id);  //�������ӱ��ɾ������
    public boolean updatep_stateservice(int p_state,int p_id); //�޸�����״̬
    public boolean updatep_titlebyp_idservice(String p_title,int p_id);    //�������ӱ���޸����ӱ���
}
