import request from '@/utils/request'

// 查询饲养头日列表
export function listCbFeedingFirstDay(query) {
  return request({
    url: '/system/cb/cbFeedingFirstDay/list',
    method: 'get',
    params: query
  })
}

// 查询饲养头日详细
export function getCbFeedingFirstDay(id) {
  return request({
    url: '/system/cb/cbFeedingFirstDay/' + id,
    method: 'get'
  })
}

// 新增饲养头日
export function addCbFeedingFirstDay(data) {
  return request({
    url: '/system/cb/cbFeedingFirstDay',
    method: 'post',
    data: data
  })
}

// 修改饲养头日
export function updateCbFeedingFirstDay(data) {
  return request({
    url: '/system/cb/cbFeedingFirstDay',
    method: 'put',
    data: data
  })
}

// 删除饲养头日
export function delCbFeedingFirstDay(id) {
  return request({
    url: '/system/cb/cbFeedingFirstDay/' + id,
    method: 'delete'
  })
}
// 查询部门下拉树结构
export function deptTreeSelect() {
  return request({
    url: '/system/cb/cbFeedingFirstDay/deptTree',
    method: 'get'
  })
}
