import request from '@/utils/request'

// 查询第三方简单生产领料单列表
export function listK3SpPickmtrl(query) {
  return request({
    url: '/system/k3cloud/k3SpPickmtrl/list',
    method: 'get',
    params: query
  })
}

// 查询第三方简单生产领料单详细
export function getK3SpPickmtrl(id) {
  return request({
    url: '/system/k3cloud/k3SpPickmtrl/' + id,
    method: 'get'
  })
}

// 新增第三方简单生产领料单
export function addK3SpPickmtrl(data) {
  return request({
    url: '/system/k3cloud/k3SpPickmtrl',
    method: 'post',
    data: data
  })
}

// 修改第三方简单生产领料单
export function updateK3SpPickmtrl(data) {
  return request({
    url: '/system/k3cloud/k3SpPickmtrl',
    method: 'put',
    data: data
  })
}

// 删除第三方简单生产领料单
export function delK3SpPickmtrl(id) {
  return request({
    url: '/system/k3cloud/k3SpPickmtrl/' + id,
    method: 'delete'
  })
}

// 调用物料接口
export function k3WebApiAcquire() {
  return request({
    url: '/system/k3cloud/k3SpPickmtrl/k3WebApiAcquire',
    method: 'post'
  })
}
