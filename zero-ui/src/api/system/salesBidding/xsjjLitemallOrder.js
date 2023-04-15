import request from '@/utils/request'

// 查询销售竞价第三方订单列表
export function listXsjjLitemallOrder(query) {
  return request({
    url: '/system/salesBidding/xsjjLitemallOrder/list',
    method: 'get',
    params: query
  })
}

// 查询销售竞价第三方订单详细
export function getXsjjLitemallOrder(id) {
  return request({
    url: '/system/salesBidding/xsjjLitemallOrder/' + id,
    method: 'get'
  })
}

// 新增销售竞价第三方订单
export function addXsjjLitemallOrder(data) {
  return request({
    url: '/system/salesBidding/xsjjLitemallOrder',
    method: 'post',
    data: data
  })
}

// 修改销售竞价第三方订单
export function updateXsjjLitemallOrder(data) {
  return request({
    url: '/system/salesBidding/xsjjLitemallOrder',
    method: 'put',
    data: data
  })
}

// 删除销售竞价第三方订单
export function delXsjjLitemallOrder(id) {
  return request({
    url: '/system/salesBidding/xsjjLitemallOrder/' + id,
    method: 'delete'
  })
}


// 主动获取成本分析报表
export function acquireXSJj() {
  return request({
    url: '/system/salesBidding/xsjjLitemallOrder/acquire',
    method: 'post'
  })
}
