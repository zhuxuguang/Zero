import request from '@/utils/request'

// 查询成本分析数据获取列表
export function listCbProductionParametersView(query) {
  return request({
    url: '/system/cbProductionParametersView/list',
    method: 'get',
    params: query
  })
}

// 查询成本分析数据获取详细
export function getCbProductionParametersView(type) {
  return request({
    url: '/system/cbProductionParametersView/' + type,
    method: 'get'
  })
}

// 新增成本分析数据获取
export function addCbProductionParametersView(data) {
  return request({
    url: '/system/cbProductionParametersView',
    method: 'post',
    data: data
  })
}

// 修改成本分析数据获取
export function updateCbProductionParametersView(data) {
  return request({
    url: '/system/cbProductionParametersView',
    method: 'put',
    data: data
  })
}

// 删除成本分析数据获取
export function delCbProductionParametersView(type) {
  return request({
    url: '/system/cbProductionParametersView/' + type,
    method: 'delete'
  })
}
