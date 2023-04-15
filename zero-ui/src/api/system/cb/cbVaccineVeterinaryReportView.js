import request from '@/utils/request'

// 查询疫苗-兽药报表视图列表
export function listCbVaccineVeterinaryReportView(query) {
  return request({
    url: '/system/cbVaccineVeterinaryReportView/list',
    method: 'get',
    params: query
  })
}

// 查询疫苗-兽药报表视图详细
export function getCbVaccineVeterinaryReportView(type) {
  return request({
    url: '/system/cbVaccineVeterinaryReportView/' + type,
    method: 'get'
  })
}

// 新增疫苗-兽药报表视图
export function addCbVaccineVeterinaryReportView(data) {
  return request({
    url: '/system/cbVaccineVeterinaryReportView',
    method: 'post',
    data: data
  })
}

// 修改疫苗-兽药报表视图
export function updateCbVaccineVeterinaryReportView(data) {
  return request({
    url: '/system/cbVaccineVeterinaryReportView',
    method: 'put',
    data: data
  })
}

// 删除疫苗-兽药报表视图
export function delCbVaccineVeterinaryReportView(type) {
  return request({
    url: '/system/cbVaccineVeterinaryReportView/' + type,
    method: 'delete'
  })
}
