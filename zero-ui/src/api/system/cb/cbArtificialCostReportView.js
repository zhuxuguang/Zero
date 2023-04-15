import request from '@/utils/request'

// 查询人工成本计算视图列表
export function listCbArtificialCostReportView(query) {
  return request({
    url: '/system/cbArtificialCostReportView/list',
    method: 'get',
    params: query
  })
}

// 查询人工成本计算视图详细
export function getCbArtificialCostReportView(type) {
  return request({
    url: '/system/cbArtificialCostReportView/' + type,
    method: 'get'
  })
}

// 新增人工成本计算视图
export function addCbArtificialCostReportView(data) {
  return request({
    url: '/system/cbArtificialCostReportView',
    method: 'post',
    data: data
  })
}

// 修改人工成本计算视图
export function updateCbArtificialCostReportView(data) {
  return request({
    url: '/system/cbArtificialCostReportView',
    method: 'put',
    data: data
  })
}

// 删除人工成本计算视图
export function delCbArtificialCostReportView(type) {
  return request({
    url: '/system/cbArtificialCostReportView/' + type,
    method: 'delete'
  })
}
