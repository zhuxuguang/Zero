import request from '@/utils/request'

// 查询人工列表
export function listCbArtificial(query) {
  return request({
    url: '/system/cb/cbArtificial/list',
    method: 'get',
    params: query
  })
}

// 查询人工详细
export function getCbArtificial(id) {
  return request({
    url: '/system/cb/cbArtificial/' + id,
    method: 'get'
  })
}

// 新增人工
export function addCbArtificial(data) {
  return request({
    url: '/system/cb/cbArtificial',
    method: 'post',
    data: data
  })
}

// 修改人工
export function updateCbArtificial(data) {
  return request({
    url: '/system/cb/cbArtificial',
    method: 'put',
    data: data
  })
}

// 删除人工
export function delCbArtificial(id) {
  return request({
    url: '/system/cb/cbArtificial/' + id,
    method: 'delete'
  })
}
// 查询部门下拉树结构
export function deptTreeSelect() {
  return request({
    url: '/system/cb/cbArtificial/deptTree',
    method: 'get'
  })
}
