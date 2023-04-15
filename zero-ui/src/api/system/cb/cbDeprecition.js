import request from '@/utils/request'

// 查询折旧列表
export function listCbDeprecition(query) {
  return request({
    url: '/system/cb/cbDeprecition/list',
    method: 'POST',
    params: query
  })
}

// 查询折旧详细
export function getCbDeprecition(id) {
  return request({
    url: '/system/cb/cbDeprecition/' + id,
    method: 'get'
  })
}

// 新增折旧
export function addCbDeprecition(data) {
  return request({
    url: '/system/cb/cbDeprecition',
    method: 'post',
    data: data
  })
}

// 修改折旧
export function updateCbDeprecition(data) {
  return request({
    url: '/system/cb/cbDeprecition',
    method: 'put',
    data: data
  })
}

// 删除折旧
export function delCbDeprecition(id) {
  return request({
    url: '/system/cb/cbDeprecition/' + id,
    method: 'delete'
  })
}
