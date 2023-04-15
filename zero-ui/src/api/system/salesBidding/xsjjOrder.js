import request from '@/utils/request'

// 查询有效订单列表
export function listXsjjOrder(query) {
  return request({
    url: '/system/salesBidding/xsjjOrder/list',
    method: 'get',
    params: query
  })
}

// 查询有效订单详细
export function getXsjjOrder(id) {
  return request({
    url: '/system/salesBidding/xsjjOrder/' + id,
    method: 'get'
  })
}

// 新增有效订单
export function addXsjjOrder(data) {
  return request({
    url: '/system/salesBidding/xsjjOrder',
    method: 'post',
    data: data
  })
}

// 修改有效订单
export function updateXsjjOrder(data) {
  return request({
    url: '/system/salesBidding/xsjjOrder',
    method: 'put',
    data: data
  })
}

// 删除有效订单
export function delXsjjOrder(id) {
  return request({
    url: '/system/salesBidding/xsjjOrder/' + id,
    method: 'delete'
  })
}

// 主动获取成本分析报表
export function acquireXSJj() {
  return request({
    url: '/system/salesBidding/xsjjOrder/acquire',
    method: 'post'
  })
}
