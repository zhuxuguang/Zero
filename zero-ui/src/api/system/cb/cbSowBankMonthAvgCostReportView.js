import request from '@/utils/request'

// 查询母猪存栏月平均成本(元/头)列表
export function listCbSowBankMonthAvgCostReportView(query) {
  return request({
    url: '/system/cbSowBankMonthAvgCostReportView/list',
    method: 'get',
    params: query
  })
}

// 查询母猪存栏月平均成本(元/头)详细
export function getCbSowBankMonthAvgCostReportView(type) {
  return request({
    url: '/system/cbSowBankMonthAvgCostReportView/' + type,
    method: 'get'
  })
}

// 新增母猪存栏月平均成本(元/头)
export function addCbSowBankMonthAvgCostReportView(data) {
  return request({
    url: '/system/cbSowBankMonthAvgCostReportView',
    method: 'post',
    data: data
  })
}

// 修改母猪存栏月平均成本(元/头)
export function updateCbSowBankMonthAvgCostReportView(data) {
  return request({
    url: '/system/cbSowBankMonthAvgCostReportView',
    method: 'put',
    data: data
  })
}

// 删除母猪存栏月平均成本(元/头)
export function delCbSowBankMonthAvgCostReportView(type) {
  return request({
    url: '/system/cbSowBankMonthAvgCostReportView/' + type,
    method: 'delete'
  })
}
