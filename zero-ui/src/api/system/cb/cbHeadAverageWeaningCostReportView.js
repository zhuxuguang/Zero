import request from '@/utils/request'

// 查询头均断奶成本计算列表
export function listCbHeadAverageWeaningCostReportView(query) {
  return request({
    url: '/system/cbHeadAverageWeaningCostReportView/list',
    method: 'get',
    params: query
  })
}

// 查询头均断奶成本计算详细
export function getCbHeadAverageWeaningCostReportView(type) {
  return request({
    url: '/system/cbHeadAverageWeaningCostReportView/' + type,
    method: 'get'
  })
}

// 新增头均断奶成本计算
export function addCbHeadAverageWeaningCostReportView(data) {
  return request({
    url: '/system/cbHeadAverageWeaningCostReportView',
    method: 'post',
    data: data
  })
}

// 修改头均断奶成本计算
export function updateCbHeadAverageWeaningCostReportView(data) {
  return request({
    url: '/system/cbHeadAverageWeaningCostReportView',
    method: 'put',
    data: data
  })
}

// 删除头均断奶成本计算
export function delCbHeadAverageWeaningCostReportView(type) {
  return request({
    url: '/system/cbHeadAverageWeaningCostReportView/' + type,
    method: 'delete'
  })
}
