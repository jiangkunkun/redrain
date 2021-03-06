/**
 * Copyright 2016 benjobs
 * <p>
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


package com.jredrain.vo;

import com.jredrain.domain.User;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RecordVo implements Serializable {

    private Long recordId;
    private Long jobId;
    private String command;
    private Integer returnCode;
    private Integer success;
    private Date startTime;
    private Date endTime;
    private Integer execType;
    private String message;
    private Integer redoCount;
    private Integer status;
    private Long flowGroup;

    private String cronExp;
    private Long operateId;
    private String operateUname;
    private Long workerId;
    private String workerName;
    private String jobName;
    private String ip;
    private User user;

    /**
     * 重跑记录对象的父记录
     */
    private Long parentId;

    /**
     * 任务类型(0:单一任务,1:流程任务)
     */
    private Integer category;

    private JobVo job;

    //重跑子记录
    private List<RecordVo> childRecord;

    //流程子任务
    private List<RecordVo> childJob;

    //是否为流程任务的最后一个子任务
    private Boolean lastFlag;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getExecType() {
        return execType;
    }

    public void setExecType(Integer execType) {
        this.execType = execType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getRedoCount() {
        return redoCount;
    }

    public void setRedoCount(Integer redoCount) {
        this.redoCount = redoCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getFlowGroup() {
        return flowGroup;
    }

    public void setFlowGroup(Long flowGroup) {
        this.flowGroup = flowGroup;
    }

    public String getCronExp() {
        return cronExp;
    }

    public void setCronExp(String cronExp) {
        this.cronExp = cronExp;
    }

    public Long getOperateId() {
        return operateId;
    }

    public void setOperateId(Long operateId) {
        this.operateId = operateId;
    }

    public String getOperateUname() {
        return operateUname;
    }

    public void setOperateUname(String operateUname) {
        this.operateUname = operateUname;
    }

    public Long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(Long workerId) {
        this.workerId = workerId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public JobVo getJob() {
        return job;
    }

    public void setJob(JobVo job) {
        this.job = job;
    }

    public List<RecordVo> getChildRecord() {
        return childRecord;
    }

    public void setChildRecord(List<RecordVo> childRecord) {
        this.childRecord = childRecord;
    }

    public List<RecordVo> getChildJob() {
        return childJob;
    }

    public void setChildJob(List<RecordVo> childJob) {
        this.childJob = childJob;
    }

    public Boolean getLastFlag() {
        return lastFlag;
    }

    public void setLastFlag(Boolean lastFlag) {
        this.lastFlag = lastFlag;
    }
}
