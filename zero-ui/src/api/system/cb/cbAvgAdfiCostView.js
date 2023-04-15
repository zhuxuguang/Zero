import request from '@/utils/request'

// 查询头均日采食量和成本计算视图列表
export function listCbAvgAdfiCostView(query) {
  return request({
    url: '/system/cbAvgAdfiCostView/list',
    method: 'get',
    params: query
  })
}

// 查询头均日采食量和成本计算视图详细
export function getCbAvgAdfiCostView(type) {
  return request({
    url: '/system/cbAvgAdfiCostView/' + type,
    method: 'get'
  })
}

// 新增头均日采食量和成本计算视图
export function addCbAvgAdfiCostView(data) {
  return request({
    url: '/system/cbAvgAdfiCostView',
    method: 'post',
    data: data
  })
}

// 修改头均日采食量和成本计算视图
export function updateCbAvgAdfiCostView(data) {
  return request({
    url: '/system/cbAvgAdfiCostView',
    method: 'put',
    data: data
  })
}

// 删除头均日采食量和成本计算视图
export function delCbAvgAdfiCostView(type) {
  return request({
    url: '/system/cbAvgAdfiCostView/' + type,
    method: 'delete'
  })
}
