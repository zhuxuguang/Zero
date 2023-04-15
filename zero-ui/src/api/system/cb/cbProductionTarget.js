import request from '@/utils/request'

// 查询生产目标列表
export function listCbProductionTarget(query) {
  return request({
    url: '/system/cb/cbProductionTarget/list',
    method: 'get',
    params: query
  })
}

// 查询生产目标详细
export function getCbProductionTarget(id) {
  return request({
    url: '/system/cb/cbProductionTarget/' + id,
    method: 'get'
  })
}

// 新增生产目标
export function addCbProductionTarget(data) {
  return request({
    url: '/system/cb/cbProductionTarget',
    method: 'post',
    data: data
  })
}

// 修改生产目标
export function updateCbProductionTarget(data) {
  return request({
    url: '/system/cb/cbProductionTarget',
    method: 'put',
    data: data
  })
}

// 删除生产目标
export function delCbProductionTarget(id) {
  return request({
    url: '/system/cb/cbProductionTarget/' + id,
    method: 'delete'
  })
}

// 查询部门下拉树结构
export function deptTreeSelect() {
  return request({
    url: '/system/cb/cbProductionTarget/deptTree',
    method: 'get'
  })
}
