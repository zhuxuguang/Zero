import request from '@/utils/request'

// 查询制造费用报表视图列表
export function listCbFabricateReportView(query) {
  return request({
    url: '/system/cbFabricateReportView/list',
    method: 'get',
    params: query
  })
}

// 查询制造费用报表视图详细
export function getCbFabricateReportView(type) {
  return request({
    url: '/system/cbFabricateReportView/' + type,
    method: 'get'
  })
}

// 新增制造费用报表视图
export function addCbFabricateReportView(data) {
  return request({
    url: '/system/cbFabricateReportView',
    method: 'post',
    data: data
  })
}

// 修改制造费用报表视图
export function updateCbFabricateReportView(data) {
  return request({
    url: '/system/cbFabricateReportView',
    method: 'put',
    data: data
  })
}

// 删除制造费用报表视图
export function delCbFabricateReportView(type) {
  return request({
    url: '/system/cbFabricateReportView/' + type,
    method: 'delete'
  })
}
