import request from '@/utils/request'

// 查询其他数据列表
export function listCbSynthetical(query) {
  return request({
    url: '/system/cb/cbSynthetical/list',
    method: 'get',
    params: query
  })
}

// 查询其他数据详细
export function getCbSynthetical(id) {
  return request({
    url: '/system/cb/cbSynthetical/' + id,
    method: 'get'
  })
}

// 新增其他数据
export function addCbSynthetical(data) {
  return request({
    url: '/system/cb/cbSynthetical',
    method: 'post',
    data: data
  })
}

// 修改其他数据
export function updateCbSynthetical(data) {
  return request({
    url: '/system/cb/cbSynthetical',
    method: 'put',
    data: data
  })
}

// 删除其他数据
export function delCbSynthetical(id) {
  return request({
    url: '/system/cb/cbSynthetical/' + id,
    method: 'delete'
  })
}

// 查询部门下拉树结构
export function deptTreeSelect() {
  return request({
    url: '/system/cb/cbSynthetical/deptTree',
    method: 'get'
  })
}

