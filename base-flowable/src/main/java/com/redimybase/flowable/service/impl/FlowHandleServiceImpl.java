package com.redimybase.flowable.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redimybase.flowable.service.FlowHandleService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.DelegationState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Vim 2018/10/12 0012 22:20
 */
@Service
public class FlowHandleServiceImpl implements FlowHandleService {


    @Override
    public Page<?> listInstance(Page page) {
        long total = runtimeService.createProcessInstanceQuery().count();

        page.setTotal(total);
        page.setRecords(runtimeService.createProcessInstanceQuery().listPage((int) page.getCurrent(), (int) page.getSize()));
        return page;
    }

    @Override
    public Page<?> listTodoTask(Page page) {
        long total = taskService.createTaskQuery().count();

        page.setTotal(total);
        page.setRecords(taskService.createTaskQuery().listPage((int) page.getCurrent(), (int) page.getSize()));
        return page;
    }

    @Override
    public Page<?> listDefinitions(Page page) {
        long total = repositoryService.createProcessDefinitionQuery().count();

        page.setTotal(total);
        page.setRecords(repositoryService.createProcessDefinitionQuery().listPage((int) page.getCurrent(), (int) page.getSize()));
        return page;
    }

    @Override
    public Page<?> listAgentTask(String userId, Page page) {
        long total = taskService.createTaskQuery().taskOwner(userId).taskDelegationState(DelegationState.PENDING).count();

        page.setRecords(taskService.createTaskQuery().taskOwner(userId).taskDelegationState(DelegationState.PENDING).listPage((int) page.getCurrent(), (int) page.getSize()));
        page.setTotal(total);
        return page;
    }

    @Override
    public Page<?> listDeployed(Page page) {
        long total = repositoryService.createDeploymentQuery().count();

        page.setTotal(total);
        page.setRecords(repositoryService.createDeploymentQuery().listPage((int) page.getCurrent(), (int) page.getSize()));
        return page;
    }


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RepositoryService repositoryService;
}
