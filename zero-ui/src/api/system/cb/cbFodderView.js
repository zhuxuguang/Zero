import request from '@/utils/request'

// 查询饲料详情报表列表
export function listCbFodderView(query) {
  return request({
    url: '/system/cbFodderView/list',
    method: 'get',
    params: query
  })
}

// 查询饲料详情报表详细
export function getCbFodderView(type) {
  return request({
    url: '/system/cbFodderView/' + type,
    method: 'get'
  })
}

// 新增饲料详情报表
export function addCbFodderView(data) {
  return request({
    url: '/system/cbFodderView',
    method: 'post',
    data: data
  })
}

// 修改饲料详情报表
export function updateCbFodderView(data) {
  return request({
    url: '/system/cbFodderView',
    method: 'put',
    data: data
  })
}

// 删除饲料详情报表
export function delCbFodderView(type) {
  return request({
    url: '/system/cbFodderView/' + type,
    method: 'delete'
  })
}
