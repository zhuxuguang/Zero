import request from '@/utils/request'

// 查询固定成本报表视图列表
export function listCbFixedCostReportView(query) {
  return request({
    url: '/system/cb/report/cbFixedCostReportView/list',
    method: 'get',
    params: query
  })
}

// 查询固定成本报表视图详细
export function getCbFixedCostReportView(type) {
  return request({
    url: '/system/cbFixedCostReportView/' + type,
    method: 'get'
  })
}

// 新增固定成本报表视图
export function addCbFixedCostReportView(data) {
  return request({
    url: '/system/cbFixedCostReportView',
    method: 'post',
    data: data
  })
}

// 修改固定成本报表视图
export function updateCbFixedCostReportView(data) {
  return request({
    url: '/system/cbFixedCostReportView',
    method: 'put',
    data: data
  })
}

// 删除固定成本报表视图
export function delCbFixedCostReportView(type) {
  return request({
    url: '/system/cbFixedCostReportView/' + type,
    method: 'delete'
  })
}
